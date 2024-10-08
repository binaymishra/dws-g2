#!/usr/bin/sh

# grab the artifact and version from gradle.env and settings.gradle

artifact=`grep "rootProject.name" settings.gradle  | cut -f2 -d= | tr -d " '"`
version=`grep "^version=" gradle.properties | cut -d= -f2`

if [ -z "${artifact}" ] || [ -z "${version}" ]; then
    echo "Unable to determine artifact and version from gradle.env and settings.gradle"
    exit 2
fi

cd build/libs

java -server -Xmx300M -XX:+UseG1GC \
     -jar "app.jar" \
     --server.port=10101 \
     --spring.profiles.active=local \
     --spring.output.ansi.enabled=always