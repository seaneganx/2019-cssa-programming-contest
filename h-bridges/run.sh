for file in *.in; do
    name="${file%%.*}"
    echo "testing $name"
    python3 soln.py < "$name.in" > temp.out
    diff "$name.ans" temp.out
done

rm temp.out
