+ ### 成员变量
```
   transient Object[] elementData; // non-private to simplify nested class access
    private int size;
```
transient的属性在对象被序列化的时候不会被保存

+ ### 构造方法
```
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }
```
有三个构造方法，无需解释，很容易理解。

* ### add(E e)
```
    public boolean add(E e) {
    	//确保不会越界
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
```
```
   private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }
```
```
    private void ensureExplicitCapacity(int minCapacity) {
    	//增加扩容次数
        modCount++;
		//超出原数组容量则调用grow()
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
```
```
   private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        //将容量增加到原来的1.5倍，拷贝数组
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

* ### add(int index, E e)
```
    public void add(int index, E element) {
        rangeCheckForAdd(index);

		//同前面一样，确保容量足够
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        //向后移动一位元素
        System.arraycopy(elementData, index, elementData, index + 1,
                         size - index);
		//插入元素
        elementData[index] = element;
        size++;
    }
```
* ### remove(int index)
```
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        //保存被删除的元素
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
        	//向前复制一位覆盖被删除的元素
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
```