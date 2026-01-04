package kt_p4_sortbinarytree_test

import p4_kyu_sortbinarytreebylevels.Tree
import p4_kyu_sortbinarytreebylevels.treeByLevels

fun main() {
    val root = Tree(1,
        left = Tree(2),
        right = Tree(3)
    )
    val res = treeByLevels(root)
    check(res.contentEquals(intArrayOf(1, 2, 3))) { "SortBinaryTreeByLevels failed" }
    println("SortBinaryTreeByLevels Kotlin tests OK")
}
