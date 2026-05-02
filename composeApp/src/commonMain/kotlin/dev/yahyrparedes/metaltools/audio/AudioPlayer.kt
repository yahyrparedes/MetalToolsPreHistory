package dev.yahyrparedes.metaltools.audio

expect class AudioPlayer() {
    fun play(resource: String)
    fun stop()
}