package yahyr.paredes.metaltoolsprehistory.audio

import android.media.MediaPlayer
import yahyr.paredes.metaltoolsprehistory.appContext
import android.util.Log

private const val TAG = "AudioPlayer"

private fun rawResIdFor(name: String): Int? {
    return when(name) {
        "inicio" -> yahyr.paredes.metaltoolsprehistory.R.raw.inicio
        "final_" -> yahyr.paredes.metaltoolsprehistory.R.raw.final_
        "audio_piedra" -> yahyr.paredes.metaltoolsprehistory.R.raw.audio_piedra
        "audio_cobre" -> yahyr.paredes.metaltoolsprehistory.R.raw.audio_cobre
        "audio_bronce" -> yahyr.paredes.metaltoolsprehistory.R.raw.audio_bronce
        "audio_hierro" -> yahyr.paredes.metaltoolsprehistory.R.raw.audio_hierro
        "initial" -> yahyr.paredes.metaltoolsprehistory.R.raw.initial
        "success" -> yahyr.paredes.metaltoolsprehistory.R.raw.success
        else -> null
    }
}

actual class AudioPlayer {

    private var mediaPlayer: MediaPlayer? = null
//    actual fun play(resource: String) {
//        stop()
//
//        // El path completo en assets
//        val afd = appContext.assets.openFd("composeResources/$resource")
//
//        mediaPlayer = MediaPlayer().apply {
//            setDataSource(
//                afd.fileDescriptor,
//                afd.startOffset,
//                afd.length
//            )
//            prepare()
//            start()
//        }
//    }
    actual fun play(resource: String) {
        stop()

        val ctx = try { appContext } catch (e: UninitializedPropertyAccessException) { null }
        if (ctx == null) {
            Log.w(TAG, "appContext no inicializado, no se puede reproducir: $resource")
            return
        }

        val resId = rawResIdFor(resource)
        if (resId != null) {
            try {
                mediaPlayer = MediaPlayer.create(ctx, resId)
                mediaPlayer?.apply {
                    setOnCompletionListener { mp -> mp.release() }
                    start()
                }
                return
            } catch (e: Exception) {
                Log.w(TAG, "Error reproduciendo raw/$resource: ${e.message}")
            }
        }

        // Fallback: intentar assets
        try {
            val afd = try {
                ctx.assets.openFd("files/audio/$resource.mp3")
            } catch (e: Exception) {
                try { ctx.assets.openFd("audio/$resource.mp3") } catch (e2: Exception) { null }
            }

            if (afd != null) {
                mediaPlayer = MediaPlayer().apply {
                    setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                    prepare()
                    start()
                }
            } else {
                Log.w(TAG, "No se encontró recurso raw ni asset para: $resource")
            }

        } catch (e: Exception) {
            Log.e(TAG, "Error reproduciendo asset para $resource: ${e.message}")
        }
    }

    actual fun stop() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}