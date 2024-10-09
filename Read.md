custom comparators - greedy 
valid paranthesis ((*))) - greedy/easy





arrays.sort()
collections.sort() for arraylist etc
list = Arrays.asList(val1, val2, val3); 


Direct way:
HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet :: new));


find . -type f | wc -l      ---- total number of files
ls | wc -l                       folders i think