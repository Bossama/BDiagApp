#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "Simple helloworld application"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://helloworld.c"

DEPENDS = "dbus dbus-glib glibc dbus-glib-native"
inherit pkgconfig

S = "${WORKDIR}"

CFLAGS_DBUS = "$(shell pkg-config --cflags --libs dbus-1)"
CFLAGS_DBUS_GLIB = "$(shell pkg-config --cflags --libs dbus-glib-1)"
CFLAGS_GIO  = "$(shell pkg-config --cflags --libs gio-2.0)"


do_compile() {
	  # ${CC} ${LDFLAGS} $(pkg-config --cflags dbus-1 glib-2.0) -o helloworld helloworld.c $(pkg-config --libs dbus-1 glib-2.0)
	    ${CC} ${CFLAGS} -o helloworld helloworld.c `pkg-config --cflags --libs dbus-glib-1` ${LDFLAGS}
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 helloworld ${D}${bindir}
}
