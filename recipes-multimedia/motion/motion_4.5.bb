DESCRIPTION = " Motion is a highly configurable program that monitors video signals from many types of cameras."
SECTION = "multimedia"
DEPENDS = "pkgconfig libmicrohttpd ffmpeg libjpeg-turbo"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "4.5"
SRC_URI = "git://github.com/Motion-Project/motion.git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig gettext
