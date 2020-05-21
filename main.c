#include <stdio.h>
//자바에서 c로 이식할 예쩡
int main(){
  int menu;
  printf("Hello, Welcome to TRPG-Ver.C.1\n");
  menu=MainGame();
  switch(menu){
    case 1: printf("GameOver\n");
      break;
    case 2: printf("You Win\nThank You For Play\n");
      break;
    case 3: printf("See You Next Time\n");
      break;
    default: printf("What happened?\n");
  }
  printf("Program is end");
  return 0;
}
