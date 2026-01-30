package yahyr.paredes.metaltoolsprehistory.platform

import android.content.Context
import android.media.MediaPlayer

fun playAudio(context: Context, audioResId: Int) {
    val mediaPlayer = MediaPlayer.create(context, audioResId)
    mediaPlayer.setOnCompletionListener {
        it.release()
    }
    mediaPlayer.start()
}