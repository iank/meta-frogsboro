DESCRIPTION = "FROGSBORO cat camera image"
LICENSE = "MIT"
PR = "r1"

require frogsboro-base.inc

IMAGE_INSTALL_append = "\
    ffmpeg \
    motion \
"

inherit core-image
