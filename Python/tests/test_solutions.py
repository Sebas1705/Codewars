import unittest
import importlib.util
import os


def load_module(path, name=None):
    base = os.path.dirname(os.path.dirname(__file__))
    # if tests were moved under Python/, paths in tests still use "Python/..."
    # normalize them so they point to the correct files under the Python/ tree
    if path.startswith('Python/'):
        rel = path[len('Python/'):]
        path = os.path.join(base, rel)
    name = name or os.path.splitext(os.path.basename(path))[0]
    spec = importlib.util.spec_from_file_location(name, path)
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    return mod


class TestKatas(unittest.TestCase):

    def test_add_big_numbers(self):
        m = load_module('Python/4-kyu/AddingBigNumbers/Solutions.py')
        self.assertEqual(m.add_big_numbers('123', '456'), '579')

    def test_count_change_combinations(self):
        m = load_module('Python/4-kyu/CountingChangeCombinations/Solutions.py')
        self.assertEqual(m.count_change_combinations(10, [5,2,3]), 4)

    def test_int32_to_ipv4(self):
        m = load_module('Python/5-kyu/Int32ToIPv4/Solutions.py')
        self.assertEqual(m.int32_to_ipv4(2149583361), '128.32.10.1')

    def test_parse_int_reload(self):
        m = load_module('Python/4-kyu/ParseIntReload/Solutions.py')
        self.assertEqual(m.parse_int_reload('seven hundred eighty-three thousand nine hundred and nineteen'), 783919)

    def test_max_subarray_sum(self):
        m = load_module('Python/5-kyu/MaximumSubarraySum/Solutions.py')
        self.assertEqual(m.max_subarray_sum([-2,1,-3,4,-1,2,1,-5,4]), 6)

    def test_is_valid_walk(self):
        m = load_module('Python/7-kyu/TakeATenMinutesWalk/Solutions.py')
        self.assertTrue(m.is_valid_walk(list('nsnsnsnsns')))

    def test_count_ip_addresses(self):
        m = load_module('Python/5-kyu/CountIPAddresses/Solutions.py')
        self.assertEqual(m.count_ip_addresses('20.0.0.10', '20.0.1.0'), 246)

    def test_rot13(self):
        m = load_module('Python/5-kyu/Rot13/Solutions.py')
        self.assertEqual(m.rot13('Hello, World!'), 'Uryyb, Jbeyq!')

    def test_matrix_determinant(self):
        m = load_module('Python/4-kyu/MatrixDeterminant/Solutions.py')
        mat = [[2,4,2],[3,1,1],[1,2,0]]
        self.assertEqual(m.matrix_determinant(mat), 10)

    def test_tree_by_levels(self):
        m = load_module('Python/4-kyu/SortBinaryTreeByLevels/Solutions.py')
        Node = m.Node
        # build small tree:    1
        #                    /   \
        #                   2     3
        root = Node(1, Node(2), Node(3))
        self.assertEqual(m.tree_by_levels(root), [1,2,3])

    def test_find_unique(self):
        m = load_module('Python/6-kyu/FindTheUniqueNumber/Solutions.py')
        self.assertEqual(m.find_unique([1,1,2,1,1]), 2)

    def test_ip_validation(self):
        m = load_module('Python/6-kyu/IPValidation/Solutions.py')
        self.assertFalse(m.is_valid_ip('192.0168.1.1'))
        self.assertTrue(m.is_valid_ip('192.168.1.1'))

    def test_tic_tac_toe_checker(self):
        m = load_module('Python/5-kyu/TicTacToeChecker/Solutions.py')
        board = ['XOX','OXO','OXX']
        self.assertEqual(m.tic_tac_toe_checker(board), 'X')

    def test_sum_two_smallest_numbers(self):
        m = load_module('Python/7-kyu/SumOfTwoLowestPositiveIntegers/Solutions.py')
        self.assertEqual(m.sum_two_smallest_numbers([5,8,12,18,22]), 13)

    def test_count_divisors(self):
        m = load_module('Python/7-kyu/CountDivisorsNumber/Solutions.py')
        self.assertEqual(m.count_divisors(36), 9)

    def test_two_oldest_ages(self):
        m = load_module('Python/7-kyu/TwoOldestAges/Solutions.py')
        self.assertEqual(m.two_oldest_ages([22,42,18,42,7]), (42,42))


if __name__ == '__main__':
    unittest.main()
