#!/usr/bin/python3
import json, sys, re, os, os.path
import numpy as np
from collections import defaultdict

bmatch = re.compile(r"^de.heidelberg.pvs.container_bench\.([a-z0-9_.]+)\.([A-Z][A-Za-z0-9_.]+)\.[a-z0-9_.]+$")
ignore = ["seed"]
trim = 2

alldata = json.load(open(sys.argv[1]))
data = defaultdict(dict)
for run in alldata:
    # print(run)
    expect = run["measurementIterations"]
    bench = run["benchmark"]
    m = bmatch.match(bench)
    if not m:
        print("Did not match:", bench, file=sys.stderr)
        continue
    params = {'pkg': m.group(1), 'bench': m.group(2), **run["params"]}
    size = params["zzsize"]
    for k in ignore + ["zzsize"]:
        try:
            del params[k]
        except:
            pass
    key = tuple(sorted(params.items()))
    unit = run["primaryMetric"]["scoreUnit"]
    raw = np.array(run["primaryMetric"]["rawData"]).flatten()
    assert (raw.shape[0] == expect)

    # Mean and standard deviation
    mean, std = np.mean(raw), np.std(raw, ddof=1)
    mi, ma = np.min(raw), np.max(raw)

    # Trimmed mean and standard deviation
    srt = np.sort(raw)[trim:-trim]  # Trim
    tmean, tstd = np.mean(srt), np.std(srt, ddof=1)

    # Median +- 1.4826 MAD
    median = np.median(raw)
    mad = np.median(np.abs(raw - median))
    madstd = 1.4826 * mad  # Assuming normal distribution
    data[key][size] = (mean, std, mi, ma, tmean, tstd, median, madstd)


for k, v in data.items():
    fname = "data/%(pkg)s/%(workload)s/%(impl)s-%(bench)s.txt" % dict(k)
    dname = os.path.dirname(fname)
    if not os.path.exists(dname): os.makedirs(dname)
    with open(fname, "w") as of:
        for size, scores in sorted(v.items()):
            print(size, *scores, file=of)
