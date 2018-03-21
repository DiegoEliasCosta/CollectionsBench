package de.heidelberg.pvs.container_bench${pkgname?"."+pkgname:""};

import java.util.Set;

${imports}

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

/**
 * Test for ${implementation} as Set<${valclass}>.
 * 
 * Generated from TemplateSetTest
 */
public class ${classname} extends AbstractJDKSetTest<${valclass}> {
	@Override
	protected Set<${valclass}> getNewSet() {
		return ${implementation}();
	}

	@Override
	protected Set<${valclass}> copySet(Set<${valclass}> orig) {
		return ${implementation}(orig);
	}
}