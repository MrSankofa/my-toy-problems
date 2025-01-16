class MinHeap {
  constructor() {
    this.heap = [];
  }

  insert(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  remove(value) {
    const index = this.heap.indexOf(value);
    if (index === -1) return;
    const last = this.heap.pop();
    if (index < this.heap.length) {
      this.heap[index] = last;
      this.bubbleDown(index);
    }
  }

  bubbleUp() {
    let index = this.heap.length - 1;
    while (index > 0) {
      let parentIndex = Math.floor((index - 1) / 2);
      if (this.heap[index] >= this.heap[parentIndex]) break;
      [this.heap[index], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[index]];
      index = parentIndex;
    }
  }

  bubbleDown(index = 0) {
    const length = this.heap.length;
    const element = this.heap[index];
    while (true) {
      let leftChildIndex = 2 * index + 1;
      let rightChildIndex = 2 * index + 2;
      let swapIndex = null;

      if (leftChildIndex < length && this.heap[leftChildIndex] < element) {
        swapIndex = leftChildIndex;
      }
      if (rightChildIndex < length &&
        this.heap[rightChildIndex] < (swapIndex === null ? element : this.heap[leftChildIndex])) {
        swapIndex = rightChildIndex;
      }
      if (swapIndex === null) break;
      [this.heap[index], this.heap[swapIndex]] = [this.heap[swapIndex], this.heap[index]];
      index = swapIndex;
    }
  }

  peek() {
    return this.heap[0];
  }
}

class MaxHeap {
  constructor() {
    this.heap = [];
  }

  insert(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  remove(value) {
    const index = this.heap.indexOf(value);
    if (index === -1) return;
    const last = this.heap.pop();
    if (index < this.heap.length) {
      this.heap[index] = last;
      this.bubbleDown(index);
    }
  }

  bubbleUp() {
    let index = this.heap.length - 1;
    while (index > 0) {
      let parentIndex = Math.floor((index - 1) / 2);
      if (this.heap[index] <= this.heap[parentIndex]) break;
      [this.heap[index], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[index]];
      index = parentIndex;
    }
  }

  bubbleDown(index = 0) {
    const length = this.heap.length;
    const element = this.heap[index];
    while (true) {
      let leftChildIndex = 2 * index + 1;
      let rightChildIndex = 2 * index + 2;
      let swapIndex = null;

      if (leftChildIndex < length && this.heap[leftChildIndex] > element) {
        swapIndex = leftChildIndex;
      }
      if (rightChildIndex < length &&
        this.heap[rightChildIndex] > (swapIndex === null ? element : this.heap[leftChildIndex])) {
        swapIndex = rightChildIndex;
      }
      if (swapIndex === null) break;
      [this.heap[index], this.heap[swapIndex]] = [this.heap[swapIndex], this.heap[index]];
      index = swapIndex;
    }
  }

  peek() {
    return this.heap[0];
  }
}

function activityNotifications(expenditure, d) {
  const minHeap = new MinHeap(); // To store the larger half
  const maxHeap = new MaxHeap(); // To store the smaller half

  function addToHeaps(value) {
    if (maxHeap.heap.length === 0 || value <= maxHeap.peek()) {
      maxHeap.insert(value);
    } else {
      minHeap.insert(value);
    }

    // Rebalance heaps
    if (maxHeap.heap.length > minHeap.heap.length + 1) {
      minHeap.insert(maxHeap.peek());
      maxHeap.remove(maxHeap.peek());
    } else if (minHeap.heap.length > maxHeap.heap.length) {
      maxHeap.insert(minHeap.peek());
      minHeap.remove(minHeap.peek());
    }
  }

  function removeFromHeaps(value) {
    if (value <= maxHeap.peek()) {
      maxHeap.remove(value);
    } else {
      minHeap.remove(value);
    }

    // Rebalance heaps
    if (maxHeap.heap.length > minHeap.heap.length + 1) {
      minHeap.insert(maxHeap.peek());
      maxHeap.remove(maxHeap.peek());
    } else if (minHeap.heap.length > maxHeap.heap.length) {
      maxHeap.insert(minHeap.peek());
      minHeap.remove(minHeap.peek());
    }
  }

  function getMedian() {
    if (d % 2 === 0) {
      return (maxHeap.peek() + minHeap.peek()) / 2;
    } else {
      return maxHeap.peek();
    }
  }

  let notifications = 0;

  for (let i = 0; i < expenditure.length; i++) {
    if (i >= d) {
      const median = getMedian();
      if (expenditure[i] >= 2 * median) {
        notifications++;
      }
      removeFromHeaps(expenditure[i - d]);
    }

    addToHeaps(expenditure[i]);
  }

  return notifications;
}