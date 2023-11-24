rm -r  bin
javac -d bin Main.java -cp .
cp -r ../Assets bin/
jar cvfm pokemon.jar Manifest.txt -C bin .
echo "To launch run: java -jar pokemon.jar"