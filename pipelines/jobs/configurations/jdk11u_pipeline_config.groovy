class Config11 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --with-cmake',
                        "hotspot"     : '--enable-dtrace=auto'
                ]
        ],

        x64MacXL    : [
                os                   : 'mac',
                arch                 : 'x64',
                additionalNodeLabels: 'macos10.14',
                test                 : 'default',
                additionalFileNameTag: "macosXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto --with-cmake'
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --enable-dtrace=auto',
                        "hotspot"     : '--enable-dtrace=auto',
                        "corretto"    : '--enable-dtrace=auto',
                        "SapMachine"  : '--enable-dtrace=auto',
                        "dragonwell"  : '--enable-dtrace=auto --enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system --with-jvm-features=zgc'
                ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        hotspot:    'win2012',
                        openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                        dragonwell: 'win2012'
                ],
                buildArgs : [
                        hotspot : '--jvm-variant client,server'
                ],
                test                : 'default'
        ],

        x64WindowsXL    : [
                os                   : 'windows',
                arch                 : 'x64',
                additionalNodeLabels : 'win2012&&vs2017',
                test                 : 'default',
                additionalFileNameTag: "windowsXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x32Windows: [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: [
                        hotspot: 'win2012',
                        openj9:  'win2012&&mingw-standalone'
                ],
                buildArgs : [
                        hotspot : '--jvm-variant client,server'
                ],
                test                : 'default'
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        hotspot: 'xlc13&&aix710',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                cleanWorkspaceAfterBuild: true
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : '--enable-dtrace=auto'
        ],

        sparcv9Solaris    : [
                os                  : 'solaris',
                arch                : 'sparcv9',
                test                : false,
                configureArgs       : '--enable-dtrace=auto'
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "hotspot"     : '--enable-dtrace=auto',
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver'
                ]

        ],

        arm32Linux    : [
                os                  : 'linux',
                arch                : 'arm',
                test                : 'default',
                configureArgs       : '--enable-dtrace=auto'
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : [
                        nightly: ['sanity.functional', 'sanity.openjdk']
                ],
                configureArgs       : [
                        "hotspot" : '--enable-dtrace=auto',
                        "openj9" : '--enable-dtrace=auto',
                        "corretto" : '--enable-dtrace=auto',
                        "dragonwell" : "--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\""
                ]
        ],

        x64LinuxXL    : [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                arch                 : 'x64',
                test                 : "default",
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-jitserver --enable-dtrace=auto'
        ],
        s390xLinuxXL    : [
                os                   : 'linux',
                arch                 : 's390x',
                test                 : 'default',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto'
        ],
        ppc64leLinuxXL    : [
                os                   : 'linux',
                arch                 : 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                 : 'default',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto --enable-jitserver'
        ],
        aarch64LinuxXL    : [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos7_build_image',
                arch                 : 'aarch64',
                test                 : 'default',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto'
        ],
        riscv64Linux      :  [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerNode         : 'sw.tool.docker && sw.config.uid1000',
                arch                 : 'riscv64',
                crossCompile         : 'x64',
                buildArgs            : '--cross-compile',
                test                 : false,
                configureArgs        : '--disable-ddr --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root'
        ],
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
