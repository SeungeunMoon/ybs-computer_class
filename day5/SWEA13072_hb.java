import java.security.NoSuchAlgorithmException;
import java.util.*;

class Node<T> {
	public T data;
	public Node<T> parent;
	public Node<T> child;

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node(T data) {
		super();
		this.data = data;
	}

}

class LinkedList<T> implements Iterable<Node<T>> {

	public Node<T> head;
	public Node<T> tail;
	public int size;

	public void addLst(LinkedList<T> lst) {

        if (lst == null || lst.size == 0) return;
        if (this.size == 0) {
            this.head = lst.head;
            this.tail = lst.tail;
            this.size = lst.size;
            return;
        }
		
		Node<T> originTail = tail;
		Node<T> addedHead = lst.head;
		originTail.child = addedHead;
		addedHead.parent = originTail;

		tail = lst.tail;
		size += lst.size;
	}

	public void addFirst(int[] data) {

		Node<T> node = new Node(data);

		node.child = head;
		if (head != null)
			head.parent = node;
		head = node;
		size++;

		if (size == 1)
			tail = node;

	}

	public void add(int[] data) {
		int idx = 0;
		if (idx == 0) {
			addFirst(data);
		} else if (idx == size) {
			addLast(data);
		} else if (size > idx || 0 > size) {
			return;
		} else {
			Node<T> post = get(idx);
			Node<T> pre = post.parent;
			Node<T> cur = new Node(data);

			pre.child = cur;
			cur.parent = pre;
			cur.child = post;
			post.parent = cur;
			size++;
		}
	}

	public Node<T> get(int idx) {
		if (idx >= size || idx < 0) {
			return null;
		}

		Node<T> curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.child;
		}

		return curr;
	}

	public void addLast(int[] data) {

		Node<T> node = new Node(data);

		node.parent = tail;
		if (tail != null)
			tail.child = node;
		tail = node;
		size++;

		if (size == 1)
			head = node;

	}

	@Override
	public Iterator<Node<T>> iterator() {
		return new Iterator<Node<T>>() {
			Node<T> current = head;

			@Override
			public Node<T> next() {
				if (current == null) throw new NoSuchElementException();
				Node<T> temp = current;
				current = current.child;
				return temp;
			}

			@Override
			public boolean hasNext() {
				return current != null;
			}
		};
	}
}

class UserSolution {
	int[][] verLst; // idx 는 mID, 내용은 버전과 팀.
	List<List<LinkedList<int[]>>> lnklst;

	public void init() {
//		System.out.println("init");
		verLst = new int[100001][2];
		lnklst = new ArrayList<>();
		// 5개 팀별 링크드리스트
		for (int i = 0; i <= 5; i++) {
			List<LinkedList<int[]>> tmplst = new ArrayList<>();

			// 팀별 내에 5개 점수별 링크드리스트
			for (int j = 0; j <= 5; j++) {
				tmplst.add(new LinkedList<int[]>());
			}
			lnklst.add(tmplst);
		}
	}

	public void hire(int mID, int mTeam, int mScore) {
		// verLst 에 버전과 팀을 저장.
		verLst[mID][0] = 1;
		verLst[mID][1] = mTeam;
		// lnklst 에 아이디와 버전을 저장.
		lnklst.get(mTeam).get(mScore).add(new int[] { mID, verLst[mID][0] });
//		System.out.println(Arrays.deepToString(verLst));
//		System.out.println(lnklst);
	}

	public void fire(int mID) {
		verLst[mID][0] = -1;
	}

	public void updateSoldier(int mID, int mScore) {
		// 팀 > 스코어 > 에다가 {mID, ++prever} 를 그냥 넣어주자. 다익스트라같은거다.
		lnklst.get(verLst[mID][1]).get(mScore).add(new int[] { mID, ++verLst[mID][0] });
	}

	public void updateTeam(int mTeam, int mChangeScore) {
		// 팀을 선택
		List<LinkedList<int[]>> curTeam = lnklst.get(mTeam);
//		System.out.println("before swtich");
//		for (int i = 1; i <= 5; i++) {
//			System.out.print("i" + i);
//			for (int[] c : curTeam.get(i)) {
//				System.out.print(Arrays.toString(c));
//			}
//			System.out.println();
//		}

		// 점수마다 스위치해주기
		if (mChangeScore >= 0) {
			for (int curScore = 5; curScore >= 1; curScore--) {
				int nextScore = Math.min(5, Math.max(1, curScore + mChangeScore));

				LinkedList<int[]> nextScoreTeam = curTeam.get(nextScore);
				LinkedList<int[]> curScoreTeam = curTeam.get(curScore);

				if (curScoreTeam != null && nextScore != curScore) {
					nextScoreTeam.addLst(curScoreTeam);
					curTeam.set(curScore, new LinkedList<int[]>());
				}
			}
		} else {
			for (int curScore = 1; curScore <= 5; curScore++) {
				int nextScore = Math.min(5, Math.max(1, curScore + mChangeScore));

				LinkedList<int[]> nextScoreTeam = curTeam.get(nextScore);
				LinkedList<int[]> curScoreTeam = curTeam.get(curScore);

				if (curScoreTeam != null && nextScore != curScore) {
					nextScoreTeam.addLst(curScoreTeam);
					curTeam.set(curScore, new LinkedList<int[]>());
				}
			}

		}
//		System.out.println("after swtich");
//		for (int i = 1; i <= 5; i++) {
//			System.out.print("i" + i);
//			for (int[] c : curTeam.get(i)) {
//				System.out.print(Arrays.toString(c));
//			}
//			System.out.println();
//		}

	}

	public int bestSoldier(int mTeam) {
		// 팀을 선택
		List<LinkedList<int[]>> curTeam = lnklst.get(mTeam);

		int ansId = 0;

		// 큰 점수부터 차례로 탐색해나가기
		for (int i = 5; i >= 1; i--) {
			LinkedList<int[]> curScore = curTeam.get(i);
			for (Node<int[]> curNode : curScore) {
				int curID = curNode.data[0];
				int curVer = curNode.data[1];

				// 최신 버전과 동일하다면
				if (curVer == verLst[curID][0]) {
					// ID 값이 더 크다면 갱신
					if (ansId < curID)
						ansId = curID;
				}
			}
			// 높은 점수에서 1개라도 나왔으면 break
			if (ansId != 0)
				break;
		}
//		System.out.println("bs" + ansId);
		return ansId;

	}

}
