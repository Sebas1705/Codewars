package p4_kyu_sortbinarytreebylevels

data class Tree(var value: Int, var left: Tree? = null, var right: Tree? = null)

fun treeByLevels(tree: Tree?): IntArray {
    if (tree == null) return intArrayOf()
    val q = ArrayDeque<Tree>()
    q.add(tree)
    val res = mutableListOf<Int>()

    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        res.add(node.value)
        node.left?.let { q.add(it) }
        node.right?.let { q.add(it) }
    }

    return res.toIntArray()
}

fun printTree(tree: Tree?) {
    if (tree == null) return
    print("${tree.value} ")
    printTree(tree.left)
    printTree(tree.right)
}

fun main() {
    val tree = Tree(
        1,
        left = Tree(2, left = Tree(4), right = Tree(5)),
        right = Tree(3, left = Tree(6), right = Tree(7, left = Tree(8)))
    )
    printTree(tree)
    println()

    val result = treeByLevels(tree)
    println(result.joinToString(" "))
}
