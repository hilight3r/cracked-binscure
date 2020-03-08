package cookiedragon.obfuscator.api

import cookiedragon.obfuscator.api.transformers.*
import cookiedragon.obfuscator.kotlin.replaceLast
import java.io.File

/**
 * @author cookiedragon234 25/Jan/2020
 */
data class RootConfiguration(
	val input: File,
	val output: File = File(input.absolutePath.replaceLast('.', "-obf.")),
	val mappingFile: File?,
	val libraries: List<File> = arrayListOf(),
	val exclusions: List<String> = arrayListOf(),
	val hardExclusions: List<String> = arrayListOf(),
	val remap: RemapConfiguration,
	val sourceStrip: SourceStripConfiguration,
	val kotlinMetadata: KotlinMetadataConfiguration,
	val crasher: CrasherConfiguration,
	val indirection: IndirectionConfiguration,
	val stringObfuscation: StringObfuscationConfiguration,
	val flowObfuscation: FlowObfuscationConfiguration,
	val ignoreClassPathNotFound: Boolean = false
) {
	override fun toString(): String  = """
		|RootConfig
		|   Input: $input
		|   Output: $output
		|   Libraries: $libraries
		|   MappingFile: $mappingFile
		|   Exclusions: $exclusions
		|   Remap: $remap
		|   SourceStrip: $sourceStrip
		|   Kotlin Metadata: $kotlinMetadata
		|   Crasher: $crasher
		|   Indirection: $indirection
		|   StringObfuscation: $stringObfuscation
	""".trimMargin()
}
