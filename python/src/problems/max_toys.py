def max_toys(prices, budget):
    prices.sort()

    count = 0
    total = 0

    for i in range(0, len(prices)):
        total += prices[i]

        if total <= budget:
            count += 1
        else:
            break

    return count
