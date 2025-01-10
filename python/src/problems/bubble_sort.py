def log_swaps(a) -> str:
    swaps = 0

    for i in range(0, len(a)):
        for j in range(0, len(a) - i - 1):

            if a[j] > a[j + 1]:
                temp = a[j + 1]
                a[j + 1] = a[j]
                a[j] = temp
                swaps += 1

    return f"""
      Array is sorted in {swaps} swaps.
      First Element: {a[0]}
      Last Element: {a[len(a) - 1]}
    """
