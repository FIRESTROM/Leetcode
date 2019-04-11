class SnakeGame(object):

    def __init__(self, width, height, food):
        """
        Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
        :type width: int
        :type height: int
        :type food: List[List[int]]
        """
        self.body = collections.deque([[0, 0]])
        self.n, self.m = height, width
        self.counter = 0
        self.foods = food[::-1]




    def move(self, direction):
        """
        Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body.
        :type direction: str
        :rtype: int
        """
        head = self.body[0][:]
        if direction == 'U':
            head[0] -= 1
            if head[0] < 0: return -1
        elif direction == 'L':
            head[1] -= 1
            if head[1] < 0: return -1
        elif direction == 'R':
            head[1] += 1
            if head[1] >= self.m: return -1
        elif direction == 'D':
            head[0] += 1
            if head[0] >= self.n: return -1

        if self.foods and head == self.foods[-1]:
            self.foods.pop()
            self.counter += 1
        else:
            self.body.pop()
            if head in self.body:
                return -1
        self.body.appendleft(head)
        return self.counter

# Your SnakeGame object will be instantiated and called as such:
# obj = SnakeGame(width, height, food)
# param_1 = obj.move(direction)
