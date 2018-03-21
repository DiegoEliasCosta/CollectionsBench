package de.heidelberg.pvs.container_bench${pkgname?"."+pkgname:""};

import java.util.Map;

${imports}

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

/**
 * Test for ${implementation} as Map<${keyclass}, ${valclass}>.
 * 
 * Generated from TemplateMapTest
 */
public class ${classname} extends AbstractJDKMapTest<${keyclass}, ${valclass}> {
	@Override
	protected Map<${keyclass}, ${valclass}> getNewMap() {
		return ${implementation}();
	}

	@Override
	protected Map<${keyclass}, ${valclass}> copyMap(Map<${keyclass}, ${valclass}> orig) {
		return ${implementation}(orig);
	}
}