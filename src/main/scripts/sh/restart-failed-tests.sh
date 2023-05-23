filepath="failedTests.txt"
testclass="*Test#"
script=""
for var in $(cat $filepath)
do
  script+="${testclass}${var}, "
  done
mvn -Dtest="$script" test
true > "$filepath"