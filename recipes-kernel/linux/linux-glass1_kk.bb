require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the Google Glass"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "glass1"

SRC_URI = "git://android.googlesource.com/kernel/omap;branch=glass-omap-xrr02;protocol=https \
    file://defconfig \
    file://img_info \
    file://0001-Create-copy-of-devfreq_trace.h.patch \
    file://0004-static-inline-in-ARM-ftrace.h.patch \
    file://0005-traps-only-use-unwind_backtrace-if-available.patch \
    file://0006-Use-Bluesleep-instead-of-Nitrous-for-BT-power-manage.patch \
    file://0007-Backport-mainline-4.1-Bluetooth-subsystem.patch \
    file://0008-it7260_ts_i2c-Remove-the-differenciation-of-Ambient-.patch \
    file://0010-ARM-uaccess-remove-put_user-code-duplication.patch "
SRCREV = "41619529af82d93ee457b4e67532ca1c54b234e2"
LINUX_VERSION ?= "3.4"
PV = "${LINUX_VERSION}+kitkat"
S = "${WORKDIR}/git"
B = "${S}"

do_install_append() {
    rm -rf ${D}/usr/src/usr/
}

BOOT_PARTITION = "/dev/mmcblk0p7"

inherit mkboot old-kernel-gcc-hdrs
