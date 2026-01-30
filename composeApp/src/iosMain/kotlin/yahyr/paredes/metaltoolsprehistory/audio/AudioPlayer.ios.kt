package yahyr.paredes.metaltoolsprehistory.audio


import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioPlayer
import platform.AVFoundation.*
import platform.Foundation.NSBundle
import platform.Foundation.NSURL

actual class AudioPlayer {

    private var player: AVAudioPlayer? = null

    @OptIn(ExperimentalForeignApi::class)
    actual fun play(resource: String) {
        stop()

        // resource = "files/audio/inicio.mp3"
        val fileName = resource.substringAfterLast("/").substringBeforeLast(".")
        val fileType = resource.substringAfterLast(".")
        val path = NSBundle.mainBundle.pathForResource(fileName, fileType) ?: return
        val url = NSURL.fileURLWithPath(path)

        player = AVAudioPlayer(contentsOfURL = url, error = null).apply {
            prepareToPlay()
            play()
        }
    }

    actual fun stop() {
        player?.stop()
        player = null
    }
}