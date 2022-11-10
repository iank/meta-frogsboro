do_install_append(){
    echo "GS0:12345:respawn:/bin/start_getty 115200 ttyGS0 vt102" >> ${D}${sysconfdir}/inittab
}
