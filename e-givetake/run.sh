for file in *.in; do
    name="${file%%.*}"
    echo "testing $name"
    java Solution < "$name.in" > temp.out
    diff "$name.ans" temp.out
done

rm temp.out
