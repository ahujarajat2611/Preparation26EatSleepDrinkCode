for dir in $(find . -type d); do
    echo "${dir}: $(find ${dir} -maxdepth 1 -type f | wc -l)"
done
