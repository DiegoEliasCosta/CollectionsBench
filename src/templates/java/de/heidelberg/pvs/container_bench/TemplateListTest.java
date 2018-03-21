package de.heidelberg.pvs.container_bench${pkgname?"."+pkgname:""};

import java.util.List;

${imports}

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

/**
 * Test for ${implementation} as List<${valclass}>.
 * 
 * Generated from TemplateListTest
 */
public class ${classname} extends AbstractJDKListTest<${valclass}> {
	@Override
	protected List<${valclass}> getNewList() {
		return ${implementation}();
	}

	@Override
	protected List<${valclass}> copyList(List<${valclass}> orig) {
		return ${implementation}(orig);
	}
}