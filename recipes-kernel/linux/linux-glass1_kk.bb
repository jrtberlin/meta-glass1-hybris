require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the Google Glass"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "glass1"

SRC_URI = "git://android.googlesource.com/kernel/omap;branch=glass-omap-xrx13b;protocol=https \
    file://0001-fix-struct-in-omap4ion-header.patch \
    file://0010-ARM-uaccess-remove-put_user-code-duplication.patch \
    file://defconfig \
    file://img_info"
SRCREV = "989d925476700c0d07a75008b37725cbc558f862"
LINUX_VERSION ?= "3.4"
PV = "${LINUX_VERSION}+kitkat"
S = "${WORKDIR}/git"
B = "${S}"

GCCVERSION ?= "6.0.%"
SDKGCCVERSION ?= "6.0.%"

do_install_append() {
    rm -rf ${D}/usr/src/usr/
}
BOOT_PARTITION = "/dev/mmcblk0p7"

inherit mkboot old-kernel-gcc-hdrs
