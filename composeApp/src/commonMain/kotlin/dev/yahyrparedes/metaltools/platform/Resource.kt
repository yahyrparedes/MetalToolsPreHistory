package dev.yahyrparedes.metaltools.platform

// En commonMain mantenemos solo nombres de recurso (String). La resolución a Painter/Drawable
// se realiza en cada plataforma (androidMain / iosMain) mediante helpers específicos.
// Para Android, utiliza `painterResourceByName(name: String)` definido en androidMain.
