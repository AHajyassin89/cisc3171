#include <cstdlib>
#include <iostream>
#include "TagSort.h"
#include "cstring.h"
void printArray(int*, int);
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {

    /*
    int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
    int n = sizeof(arr)/sizeof(arr[0]);
    
    int *ptrArray[n]; 
    for (int i = 0; i < n; i++) {
      ptrArray[i] = &arr[i]; // assign the address of integer.
   }
    cout << *ptrArray[2] << endl;
    sort(ptrArray, n); 
    cout << *ptrArray[2] << endl;
    printf("Sorted array: \n"); 
    printArray(arr, n); 
    */
    
    char s1[100] = "Hello", s2[100] = "world", s3[100];

	cout << "s1: " << s1 << ": (" << strlen(s1) << ")" << endl;
	cout << "s2: " << s2 << ": (" << strlen(s2) << ")" << endl;

	cout << "strcpy: " << strcpy(s3, s1) << endl;

	cout << "s3: " << s3 << ": (" << strlen(s3) << ")" << endl;

	cout << "strcat: " << strcat(s3,  " ") << endl;

	cout << "s3: " << s3 << ": (" << strlen(s3) << ")" << endl;

	cout << "strcat: " << strcat(s3,  s2) << endl;

	cout << s3 << ": " << strlen(s3) << endl;

	char s4[100];

	cout << strcat(strcat(strcpy(s4, s1), " "), s2) << endl;

	cout << s4 << ": " << strlen(s4) << endl;

	const char *pos = strchr(s1, 'l');
	if (!pos)
		cout << "'l' not found in " << s1 << endl;
	else
		cout << "'l' found at position " << (pos - s1) << " in " << s1 << endl;

	pos = strchr(s1, 'e');
	if (!pos)
		cout << "'e' not found in " << s1 << endl;
	else
		cout << "'e' found at position " << (pos - s1) << " in " << s1 << endl;

	pos = strrchr(s4, 'l');
	if (!pos)
		cout << "'l' not found in " << s4 << endl;
	else
		cout << "'l' last found at position " << (pos - s4) << " in " << s4 << endl;

	pos = strrchr(s4, ',');
	if (!pos)
		cout << "',' not found in " << s4 << endl;
	else
		cout << "',' last found at position " << (pos - s1) << " in " << s4 << endl;

	cout << "strcmp(s1, s1): " << strcmp(s1, s1) << endl;
	cout << "strcmp(s1, s2): " << strcmp(s1, s2) << endl;
	cout << "strcmp(s2, s1): " << strcmp(s2, s1) << endl;
	cout << "strcmp(s1, s4): " << strcmp(s1, s4) << endl;
    
    
    
    return 0;
}

void printArray(int arr[], int size) 
{ 
    int i; 
    for (i=0; i < size; i++) 
        printf("%d ", arr[i]); 
    printf("n"); 
} 