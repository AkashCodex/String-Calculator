import java.util.*;

public class StringCalculator
{
    private readonly List<string> _defaultDelimiters = new List<string> { ",", "\n" };
    private const int StartIndexOfNumbersWithCustomDelimiter = 3;
    private const int StartIndexOfCustomDelimiter = 2;
    private const int MaxNumberLimit = 1000;
    private const string CustomDelimiterIdentifier = "//";

    public int Add(string numbers)
    {
        if (string.IsNullOrEmpty(numbers)) return 0;

        if (numbers.StartsWith(CustomDelimiterIdentifier))
        {
            numbers = GetNumbersExcludingCustomDelimiter(numbers);
        }

        var sumOfNumbers = GetSumOfNumbers(numbers);

        return sumOfNumbers;
    }

    private int GetSumOfNumbers(string numbers)
    {
        var convertedNumbers = numbers.Split(_defaultDelimiters.ToArray(), StringSplitOptions.None).Select(int.Parse).ToList();

        ValidateNumbersArePositive(convertedNumbers);

        var sumOfNumbers = convertedNumbers.Where(x => x <= MaxNumberLimit).Sum();
        return sumOfNumbers;
    }


    private string GetNumbersExcludingCustomDelimiter(string numbers)
    {
        var startIndexOfString = AssignCustomDelimiterAndReturnStartIndexOfNumbers(numbers);

        numbers = numbers.Substring(startIndexOfString);
        return numbers;
    }


}  


class Main{
   public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    string inputOfString = input.nextString();
    StringCalculator object = new StringCalculator();
    object.Add(inputOfString);   
   }
}