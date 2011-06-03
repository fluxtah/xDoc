package org.eclipse.xtext.xdoc.generator.util

import org.eclipse.xtext.common.types.*

class GitExtensions {
	
	def gitLink (JvmIdentifiableElement ie){
		val compilationUnitName = ie.compilationUnitName
		val prefix = 
			switch name: ie.qualifiedName {
				case name.startsWith("org.eclipse.xtext.common.types.xtext.ui"):
					"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.common.types.ui/src/"
	//			case name.startsWith("org.eclipse.xtext.common.types"):
	//				"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.common.types/src/"
				case name.startsWith("org.eclipse.xtext.ui.shared"):
					"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.ui.shared/src/"
				case name.startsWith("org.eclipse.xtext.generator") ||
						name.startsWith("org.eclipse.xtext.ui.generator"):
					"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.generator/src/"
				case name.startsWith("org.eclipse.xtext.ui"):
					"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.ui/src/"			
				case name.startsWith("org.eclipse.xtext.junit"):
					"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.junit/src/"
				case name.startsWith("org.eclipse.xtext.xtext"):
					"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.xtext/src/"
				case name.startsWith("org.eclipse.xtext.ui"):// org.eclipse.xtext.common.services.DefaultTerminalConverters
					"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.ui/src/"
				case name.startsWith("org.eclipse.xtext"):// org.eclipse.xtext.common.services.DefaultTerminalConverters
					"http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext/src/"
				default:
					""
			}
			if(prefix.length != 0)
				prefix + ie.qualifiedName.replaceAll("\\.", "/").replaceAll("\\$.*$", "") + ".java"
			else
				null
	}


//org.eclipse.xtext.mwe.Reader



//org.eclipse.xtext.service.DispatchingProvider$Runtime
/*
org.eclipse.xtext.ui.label.AbstractLabelProvider
org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider
org.eclipse.xtext.ui.shared.internal.SharedModule
org.eclipse.xtext.validation.AbstractDeclarativeValidator
org.eclipse.xtext.validation.Check
org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider
org.eclipse.xtext.validation.IConcreteSyntaxValidator
org.eclipse.xtext.validation.impl.ConcreteSyntaxDiagnosticProvider
org.eclipse.xtext.validation.impl.ConcreteSyntaxEValidator
org.eclipse.xtext.validation.impl.ConcreteSyntaxValidator
*/
	def compilationUnitName(JvmIdentifiableElement ie) {
		ie.simpleName
	}
}