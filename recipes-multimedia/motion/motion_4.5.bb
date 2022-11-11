DESCRIPTION = " Motion is a highly configurable program that monitors video signals from many types of cameras."
SECTION = "multimedia"
DEPENDS = "pkgconfig libmicrohttpd ffmpeg libjpeg-turbo"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "4.5"
SRC_URI = "git://github.com/Motion-Project/motion.git \
           file://motion.conf \
           file://motion.init \
"

S = "${WORKDIR}/git"

inherit autotools pkgconfig gettext update-rc.d

INITSCRIPT_NAME = "motion"
INITSCRIPT_PARAMS = "start 99 2 3 4 5 . stop 60 0 1 6 ."

do_install_append () {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/motion.init ${D}${sysconfdir}/init.d/motion

    install -d ${D}${sysconfdir}/motion
    install -m 0644 ${WORKDIR}/motion.conf ${D}${sysconfdir}/motion/motion.conf

    install -d ${D}/data/motion
    chown root:root ${D}/data/motion
}

CONFFILES_${PN} += "${sysconfdir}/motion/motion.conf"
FILES_${PN} += "/data/motion"
