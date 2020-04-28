#!/bin/bash
currentDir="$(dirname $0)"
export BTRACE_HOME=/Users/sws/IdeaProjects/btrace
export PATH=$BTRACE_HOME/bin:$PATH

pid="$(jps | grep "StringTableTest"|cut -d " " -f1)"

btrace $pid $currentDir/TraceMethodArgsAndReturn.java