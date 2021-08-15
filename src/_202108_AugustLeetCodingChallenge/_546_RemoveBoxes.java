package _202108_AugustLeetCodingChallenge;

import java.util.ArrayList;
import java.util.List;

public class _546_RemoveBoxes {

    private static final class Range {
        public final byte color;
        public final short count;

        public Range(final byte color, final short count) {
            this.color = color;
            this.count = count;
        }
    }

    public final int removeBoxes(final int[] boxes) {
        final List<Range> arr = new ArrayList<>();
        int color = 0;
        short count = 0;
        for (final int n : boxes) {
            if (color == 0) {
                color = n;
                count++;
            } else if (color == n) {
                count++;
            } else {
                arr.add(new Range((byte) color, count));
                color = n;
                count = 1;
            }
        }
        arr.add(new Range((byte) color, count));
        final Range[] ranges = arr.toArray(new Range[]{});
        final int n = boxes.length + 1;
        final int n2 = n * n;
        final short[] cache = new short[n * n2];
//        final ByteBuffer cache = ByteBuffer.allocateDirect(n * n2 * 2);

        final int result = bestScore(ranges, 0, ranges.length, (short) 0, cache, n, n2);
        return result;
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    private static short bestScore(
            final Range[] ranges,
            int i,
            int j,
            short k,
            final short[] cache,
            final int n,
            final int n2
    ) {
        final int key = i * n + j * n2 + k;
        short score = cache[key];
        if (score == 0) {
            final int color = ranges[i].color;
            if (j - i > 1 && ranges[j - 1].color == color) {
                k += ranges[i].count + ranges[j - 1].count;
                j--;
            } else {
                k += ranges[i].count;
            }
            i++;
            score = (short) (k * k);
            if (i != j) {
                score += bestScore(ranges, i, j, (short) 0, cache, n, n2);
                for (int mid = i + 1; mid < j - 1; mid++) {
                    if (ranges[mid].color == color) {
                        final short scoreForRemoved = bestScore(ranges, i, mid, (short) 0, cache, n, n2);
                        final short scoreForJoined = bestScore(ranges, mid, j, k, cache, n, n2);
                        final short scoreForAttempt = (short) (scoreForRemoved + scoreForJoined);
                        score = score > scoreForAttempt ? score : scoreForAttempt;
                    }
                }
            }
            cache[key] = score;
        }
        return score;
    }

}
