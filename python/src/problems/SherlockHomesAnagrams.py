def sherlock_homes_find_anagrams(targetStr: str) -> int:
    pairs = 0
    permutationMap = {}

    # find all permutations of the targetString
    for start in range(len(targetStr)):
        substring = ""

        for next_char_index in range(start, len(targetStr)):
            substring += targetStr[next_char_index]

            substring = "".join(sorted(substring))

            # keep track of how many permutations there are
            if substring in permutationMap:
                permutationMap[substring] = permutationMap[substring] + 1

            else:
                permutationMap[substring] = 1

    # count how many pairs there are

    for key, value in permutationMap.items():
        if value >= 2:
            allPossibleFactors = value * (value - 1)

            totalUniquePairs = allPossibleFactors / 2

            pairs += totalUniquePairs

    # return the number of pairs
    return int(pairs)
