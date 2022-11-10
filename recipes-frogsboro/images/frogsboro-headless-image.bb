DESCRIPTION = "FROGSBORO image"
LICENSE = "MIT"
PR = "r1"

ROOTFS_POSTPROCESS_COMMAND += "frogsboro_provisioning;"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base-wifi \
    packagegroup-base-usbgadget \
    kernel-modules \
    lrzsz \
    setserial \
    opkg \
    iperf3 \
    \
    nbench-byte \
    lmbench \
    \
    linux-firmware-sd8686 \
    linux-firmware-sd8688 \
    linux-firmware-sd8787 \
    linux-firmware-sd8797 \
    linux-firmware-sd8801 \
    linux-firmware-sd8887 \
    linux-firmware-sd8897 \
    linux-firmware-ralink \
    linux-firmware-rtl8188 \
    linux-firmware-rtl8723 \
    linux-firmware-rtl8821 \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192su \
    linux-firmware-rtl8723 \
    mchp-wireless-firmware \
    \
    alsa-utils \
    i2c-tools \
    devmem2 \
    libgpiod-tools \
    dosfstools \
    libdrm-tests \
    mtd-utils \
    mtd-utils-ubifs \
    dtc \
    dtc-misc \
    iproute2 \
    iptables \
    bridge-utils \
    evtest \
    python3-pyserial \
    python3-smbus \
    python3-ctypes \
    python3-pip \
    gdb \
    usbutils \
    wget \
    hostapd \
    9bit \
    rng-tools \
    wireless-regdb-static \
    libdrm \
    net-tools \
    nftables \
    phytool \
    tcpdump \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

frogsboro_provisioning() {
    echo "# The loopback interface"                    > ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "auto lo"                                    >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "iface lo inet loopback"                     >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo ""                                           >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "# Wireless interfaces"                      >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "auto wlan0"                                 >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "iface wlan0 inet dhcp"                      >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "        wireless_mode managed"              >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "        wireless_essid any"                 >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "        wpa-driver wext"                    >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces
    echo "        wpa-conf /data/wpa_supplicant.conf" >> ${IMAGE_ROOTFS}${sysconfdir}/network/interfaces

    install -d ${IMAGE_ROOTFS}/data
    ln -sfr ${IMAGE_ROOTFS}/data/hostname ${IMAGE_ROOTFS}${sysconfdir}/hostname

    lnr ${IMAGE_ROOTFS}/data/.ssh ${IMAGE_ROOTFS}/home/root/.ssh
}

inherit core-image
