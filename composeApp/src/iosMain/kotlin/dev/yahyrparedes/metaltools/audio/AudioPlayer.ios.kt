package dev.yahyrparedes.metaltools.audio


import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioPlayer
import platform.Foundation.NSBundle
import platform.Foundation.NSURL
import platform.Foundation.NSFileManager

// Mapeo de nombres a archivos de audio con sus extensiones
private fun getAudioFileInfo(name: String): Pair<String, String>? {
    return when(name) {
        "inicio" -> "inicio" to "mp3"
        "final_" -> "final_" to "mp3"
        "audio_piedra" -> "audio_piedra" to "mp3"
        "audio_cobre" -> "audio_cobre" to "mp3"
        "audio_bronce" -> "audio_bronce" to "mp3"
        "audio_hierro" -> "audio_hierro" to "mp3"
        "initial" -> "initial" to "mp3"
        "success" -> "success" to "mp3"
        else -> null
    }
}

actual class AudioPlayer {

    private var player: AVAudioPlayer? = null

    @OptIn(ExperimentalForeignApi::class)
    actual fun play(resource: String) {
        stop()

        val audioInfo = getAudioFileInfo(resource) ?: run {
            println("AudioPlayer: Audio resource not found: $resource")
            return
        }

        val (fileName, fileType) = audioInfo

        // Buscar en diferentes ubicaciones del bundle
        val searchPaths = listOf(
            "files/audio/$fileName",  // composeResources/files/audio/
            "audio/$fileName",         // composeResources/audio/
            "Resources/files/audio/$fileName",  // iOS Resources folder
            fileName                   // Raíz del bundle
        )

        var path: String? = null
        val fileManager = NSFileManager.defaultManager

        println("AudioPlayer: Searching for $fileName.$fileType in bundle")

        for (searchPath in searchPaths) {
            val foundPath = NSBundle.mainBundle.pathForResource(searchPath, fileType)
            if (foundPath != null) {
                path = foundPath
                println("AudioPlayer: ✓ Found audio at: $searchPath.$fileType")
                break
            } else {
                println("AudioPlayer: ✗ Not found at: $searchPath.$fileType")
            }
        }

        if (path == null) {
            println("AudioPlayer: ✗ Audio file not found in bundle: $fileName.$fileType")
            println("AudioPlayer: Bundle path: ${NSBundle.mainBundle.bundlePath()}")

            // Debug: List all mp3 files in bundle
            val bundlePath = NSBundle.mainBundle.resourcePath
            if (bundlePath != null) {
                println("AudioPlayer: Bundle resource path: $bundlePath")
                try {
                    val contents = fileManager.contentsOfDirectoryAtPath(bundlePath, null)
                    println("AudioPlayer: Bundle contents (first 20): ${contents?.take(20)}")
                } catch (e: Exception) {
                    println("AudioPlayer: Could not list bundle contents: ${e.message}")
                }
            }
            return
        }

        val url = NSURL.fileURLWithPath(path)

        try {
            player = AVAudioPlayer(contentsOfURL = url, error = null).apply {
                prepareToPlay()
                play()
            }
            println("AudioPlayer: ✓ Playing audio: $fileName.$fileType")
        } catch (e: Exception) {
            println("AudioPlayer: ✗ Error playing audio: ${e.message}")
        }
    }

    actual fun stop() {
        player?.stop()
        player = null
    }
}