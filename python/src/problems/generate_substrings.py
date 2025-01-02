def generate_substrings(str):
    substrings = []

    for index in range(0, len(str)):
        substring = ""

        for start in range(index, len(str)):
            substring += str[start]

            substrings.append(substring)

    return substrings
