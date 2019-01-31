class UnionFind():
    def __init__(self, n):
        self.parent = [x for x in range(n)]
        self.rank = [0 for _ in range(n)]

    def union(self, x ,y):
        x_root = self.find(x)
        y_root = self.find(y)
        if x_root == y_root:
            return
        if self.rank[x_root] < self.rank[y_root]:
            x_root, y_root = y_root, x_root
        self.parent[y_root] = x_root
        if self.rank[x_root] == self.rank[y_root]:
            self.rank[x_root] += 1

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

edge_to_faces = {}
edge_to_cost = {}
pen_count = int(input())
for pen in range(pen_count):
    corner_count, *desc = input().split()
    corner_count = int(corner_count)
    corners = [int(x) for x in desc[:corner_count]]
    costs = [int(x) for x in desc[corner_count:]]
    for i, start in enumerate(corners):
        j = (i + 1) % corner_count
        next = corners[j]
        edge = (min(start, next), max(start, next))
        if edge not in edge_to_faces:
            edge_to_faces[edge] = []
        edge_to_faces[edge].append(pen)
        edge_to_cost[edge] = costs[i]

graph = [[] for _ in range(pen_count + 1)]
edges = {}
for cost, faces in zip(edge_to_cost.values(), edge_to_faces.values()):
    if len(faces) == 1:
        faces.append(pen_count)
    f1, f2 = min(faces), max(faces)
    graph[f1].append((f2, cost))
    graph[f2].append((f1, cost))
    if (f1, f2) not in edges:
        edges[(f1, f2)] = cost
    else:
        edges[(f1, f2)] = min(edges[(f1, f2)], cost)

cost_with_outside = 0
uf = UnionFind(pen_count + 1)
ordered_edges = sorted(edges, key=edges.get)
for u, v in ordered_edges:
    if uf.find(u) == uf.find(v):
        continue
    uf.union(u, v)
    cost_with_outside += edges[(u, v)]

cost_without_outside = 0
uf = UnionFind(pen_count)
ordered_edges = [(u, v) for (u, v) in ordered_edges if u != pen_count and v != pen_count]
for u, v in ordered_edges:
    if uf.find(u) == uf.find(v):
        continue
    uf.union(u, v)
    cost_without_outside += edges[(u, v)]

print(min(cost_with_outside, cost_without_outside))
