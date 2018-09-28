#!/usr/bin/python
import gzip, json, matplotlib, yaml, re, sys
import numpy as np
import matplotlib.pyplot as plt
from collections import defaultdict, Counter

from yaml.representer import Representer
yaml.add_representer(defaultdict, Representer.represent_dict)
yaml.add_representer(unicode, lambda self, x: self.represent_str(x.encode("utf-8")))
yaml.add_representer(tuple, Representer.represent_list)

plt.style.use(["seaborn-paper", "seaborn-colorblind", "style.mplstyle"])

pretty_part = {"JDK": "JDK", "CORENLP": "CoreNLP", "HPPC": "HPPC",
	"O2O": "", "O2I" : "primitive",
	"HASH": "", "LINKEDHASH" : "Linked", "LINKED" : "Linked", "QHASH" : "Quadratic",
	"HASHTABLE" : "HashTable", "ARRAY" : "Array", "TREE" : "Tree",
	"SORTED" : "Sorted", "SCATTER" : "Scatter", "MULTISET" : "MultiSet" }
pretty_key = {}

markers = ['+', 'o', '*', 'v', '^', '.', ',', 'P', 'X'] # last is for arrays, second last is linked
colors = "#ed420e,#fdca19,#4548a5,#7ebd3a,#a81e51,#00748b,#fa8116,#512d85,#008a7a,#fea918,#019d60,#cfde3d,#015a9c,#7b1760".split(",") # ELKI colors
#colors = "#F3C300,#875692,#F38400,#A1CAF1,#BE0032,#C2B280,#008856,#E68FAC,#0067A5,#F99379,#848482,#F6A600,#B3446C,#DCD300,#604E97,#882D17,#8DB600,#654522,#E25822,#2B3D26".split(",") # kelly colors

data = json.load(gzip.open("wordcount-compressed.json.gz"))
ideal, ideal2 = 8, 4 # compressed pointer
fnprefix = "wordcount-memc-"
data = json.load(gzip.open("wordcount-nocompressed.json.gz"))
ideal, ideal2 = 14, 8 # noncompressed
fnprefix = "wordcount-mem64-"

# Clean some useless parts
totaltime = 0
for part in data:
	totaltime += part["primaryMetric"]["score"]
	for m in [part["primaryMetric"]] + part["secondaryMetrics"].values():
		assert len(m["rawData"]) == 1, yaml.safe_dump(part)
		assert len(m["rawData"][0]) == 1, yaml.safe_dump(part)
		del m["rawData"], m["scoreConfidence"], m["scoreError"], m["scorePercentiles"]
print "Total runtime", totaltime / 1000000., "s"

numentries, payload = dict(), dict()
memory = defaultdict(lambda: defaultdict(dict))
tables = defaultdict(lambda: defaultdict(dict))
for part in data:
	bench = re.search("\.([A-Z][A-Za-z0-9]+)\.", part["benchmark"]).group(1)
	params, secondary = part["params"], part["secondaryMetrics"]
	impl = params["impl"]
	if impl in ["BLACKHOLE", "NOOP"]: continue
	size = int(params["size"])
	ent = secondary["numentries"]["score"]
	if ent == size:
		if not impl in ["GUAVA_LINKEDHASH_MULTISET", "GUAVA_HASH_MULTISET"]: # Guava counted all, not distinct
			assert numentries.get(size, ent) == ent, yaml.safe_dump(part)
	else:
		numentries[size] = ent
	if impl == "PAYLOAD":
		payload[size] = secondary["totalmemory"]["score"]
		continue
	# if part["secondaryMetrics"]["numentries"]["rawData"][0][0] == size: print yaml.safe_dump(part)
	memory[impl][bench][size] = secondary["totalmemory"]["score"]
	tables[impl][bench][size] = secondary["tablesizemax"]["score"]

#print yaml.safe_dump(data[-10])

colormap = {"JDK": colors[0], "Fastutil": colors[1], "Koloboke": colors[2], "Eclipse": colors[3], "Apache": colors[4]}
### Generate pretty keys, assign colors:
for k in memory.keys():
	if pretty_key.get(k): continue
	ps = k.split("_")
	#if ps[-1] == "HASH": ps = ps[:-1]
	#if ps[-1] == "LINKEDHASH": ps[-1] = "Linked"
	ps = [pretty_part.get(ps[0]) or (ps[0][0] + ps[0][1:].lower())] + map(lambda x: pretty_part.get(x,x), ps[1:])
	ps = filter(lambda x: x, ps)
	#if len(ps) > 1 and ps[1] == "O2O": del ps[1]
	pretty_key[k] = " ".join(ps)
	if not colormap.get(ps[0]): colormap[ps[0]] = colors[len(colormap)]
#print colormap

def keyfunc(x):
	if isinstance(x, tuple): x=x[0]
	g = 0 if x.startswith("JDK") else 1
	x = x.replace("_O2O_","__")
	return (g, x[:-5] if x.endswith("_HASH") else x)

########### 1. Unique words
unique = np.array( sorted(numentries.items()) )

plt.xscale('log')
plt.xlabel('Total Tokens')
plt.yscale('log')
plt.ylabel('Unique Tokens')
plt.grid()
plt.plot(unique[:,0], unique[:,1], marker='o')
plt.savefig("word-counts.pdf", bbox_inches='tight')
#plt.show()

########### 2. Memory usage
#print memory.keys()
zorder=1000
def marker(variants, grp, label):
	if "Linked" in label: return markers[-2]
	if "Array" in label: return markers[-1]
	r = variants[grp]
	variants[grp] += 1
	return markers[r]

plt.figure(figsize=(10, 7))
plt.xscale('log')
plt.xlabel('Unique Tokens')
#plt.yscale('log')
plt.ylabel('Overhead per Unique Token [Bytes]')
plt.ylim( (0,150) )
plt.grid()
variants = Counter()
for k, v in sorted(memory.items(), key=keyfunc):
	if "O2I" in k: continue
	if not "HASH" in k: continue
	label = pretty_key.get(k, k)
	grp = label.split(" ")[0]
	row = v["JDKGetPut"]
	if not row: continue
	row = np.array([ (numentries[x], (y-payload[x])/numentries[x]) for x,y in sorted(row.items()) ])
	plt.plot(row[:,0], row[:,1], label=label, color=colormap[grp], marker=marker(variants, grp, label), markersize=10, zorder=zorder)
	zorder-=1
plt.axhline(y=ideal, linestyle=":", color="#CCCCCC")
#plt.axhline(y=ideal2, linestyle="--", color="#CCCCCC")
plt.legend(loc="upper right", ncol=3)
plt.yticks(range(0,150,16))
plt.savefig(fnprefix + "jcf.pdf", bbox_inches='tight')
#plt.show()

### Mutable
plt.figure(figsize=(10, 7))
plt.xscale('log')
plt.xlabel('Unique Tokens')
#plt.yscale('log')
plt.ylabel('Overhead per Unique Token [Bytes]')
plt.ylim( (0,150) )
plt.grid()
variants = Counter()
for k, v in sorted(memory.items(), key=keyfunc):
	if "O2I" in k: continue
	if not "HASH" in k: continue
	label = pretty_key.get(k, k)
	grp = label.split(" ")[0]
	row = v["MutableJDKGetPut"] # or v["MutableScalaGetPut"]
	if not row: continue
	row = np.array([ (numentries[x], (y-payload[x])/numentries[x]) for x,y in sorted(row.items()) ])
	plt.plot(row[:,0], row[:,1], label=label, color=colormap[grp], marker=marker(variants, grp, label), markersize=10, zorder=zorder)
	zorder-=1
plt.axhline(y=ideal, linestyle=":", color="#CCCCCC")
#plt.axhline(y=ideal2, linestyle="--", color="#CCCCCC")
plt.legend(loc="upper right", ncol=3)
plt.yticks(range(0,150,16))
plt.savefig(fnprefix + "mutable.pdf", bbox_inches='tight')
#plt.show()


# Primitives
plt.figure(figsize=(10, 7))
plt.xscale('log')
plt.xlabel('Unique Tokens')
#plt.yscale('log')
plt.ylabel('Overhead per Unique Token [Bytes]')
plt.ylim( (0,150) )
plt.grid()
variants = Counter()
for k, v in sorted(memory.items(), key=keyfunc):
	if not "O2I" in k: continue
	#if not "HASH" in k: continue
	label = pretty_key.get(k, k)
	grp = label.split(" ")[0]
	row = v["JDKGetPut"] or v.values()[0]
	if not row: continue
	row = np.array([ (numentries[x], (y-payload[x])/numentries[x]) for x,y in sorted(row.items()) ])
	label = label.replace(" primitive", "")
	plt.plot(row[:,0], row[:,1], label=label, color=colormap[grp], marker=marker(variants, grp, label), markersize=10, zorder=zorder)
	zorder-=1
plt.axhline(y=ideal, linestyle=":", color="#CCCCCC")
#plt.axhline(y=ideal2, linestyle="--", color="#CCCCCC")
plt.legend(loc="upper right", ncol=3)
plt.yticks(range(0,150,16))
plt.savefig(fnprefix + "primitives.pdf", bbox_inches='tight')
#plt.show()

# Primitives
plt.figure(figsize=(10, 7))
plt.xscale('log')
plt.xlabel('Unique Tokens')
#plt.yscale('log')
plt.ylabel('Overhead per Unique Token [Bytes]')
plt.ylim( (0,150) )
plt.grid()
variants = Counter()
for k, v in sorted(memory.items(), key=keyfunc):
	if "HASH" in k: continue
	if "O2I" in k: continue
	label = pretty_key.get(k, k)
	grp = label.split(" ")[0]
	row = v["JDKGetPut"] or v.values()[0]
	if not row: continue
	row = np.array([ (numentries[x], (y-payload[x])/numentries[x]) for x,y in sorted(row.items()) ])
	plt.plot(row[:,0], row[:,1], label=label, color=colormap[grp], marker=marker(variants, grp, label), markersize=10, zorder=zorder)
	zorder-=1
plt.axhline(y=ideal, linestyle=":", color="#CCCCCC")
#plt.axhline(y=ideal2, linestyle="--", color="#CCCCCC")
plt.legend(loc="upper right", ncol=3)
plt.yticks(range(0,150,16))
plt.savefig(fnprefix + "others.pdf", bbox_inches='tight')
#plt.show()

#yaml.dump(memory["JDK_O2O_HASH"], sys.stdout)
#yaml.dump(memory["FASTUTIL_O2I_HASH"], sys.stdout)

costs = defaultdict(list)
for k, v in sorted(memory.items(), key=keyfunc):
	row1, row2 = v["JDKGetPut"], v["MutableJDKGetPut"]
	if not row1 or not row2: continue
	for x in sorted(row1.keys()):
		costs[x].append((row2[x] - row1[x]) / float(numentries[x]))

print "Overhead of MutableInteger:"
for x in sorted(costs.keys()): print x, np.mean(costs[x]), np.std(costs[x])

print "Load factors, storage cost:"
for k, v in sorted(tables.items(), key=keyfunc):
	# if not "HASH" in k or "LINKED" in k: continue
	prev = -1
	for b, v2 in v.items():
		last = sorted(v2.items())[-1]
		if memory[k][b][last[0]] == prev: continue
		if last[1] > 0: print "%-23s\t%-23s\t%.3f\t%5.1f" % (k, b, numentries[last[0]]/last[1], memory[k][b][last[0]]/numentries[last[0]])

for k, v in sorted(memory.items(), key=keyfunc):
	label = pretty_key.get(k, k)
	print "\\\\\n"+label
	row = v["JDKGetPut"] or v.values()[0]
	size, mem = sorted(row.items())[-1]
	print "& %.1f & %.1f" % (mem/numentries[size], (mem-payload[size])/numentries[size]),
	row = v["MutableJDKGetPut"] or v["MutableScalaGetPut"] or None
	if not row:
		print "& - & -",
	else:
		size, mem = sorted(row.items())[-1]
		print "& %.1f & %.1f" % (mem/numentries[size], (mem-payload[size])/numentries[size]),
	print
