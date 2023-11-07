package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.Constants.*;
import static lotto.view.Message.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }


    public int countMatch(Lotto winningNumbers){
        return (int)numbers.stream().filter(winningNumbers ::containNumber).count();
    }

    public boolean containNumber(int num){
        return numbers.contains(num);
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUM_OF_LOTTO) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    private void checkOverlap(List<Integer> numbers){
        Set<Integer> overlapCheck = new HashSet<>();
        for(int i=0; i<numbers.size(); i++)
        {
            overlapCheck.add(numbers.get(i));
        }
        if(overlapCheck.size()!=6){
            throw new IllegalArgumentException(OVERLAP_NUM_ERROR);
        }

    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(OVERLAP_NUM_ERROR);
        }
    }

}
