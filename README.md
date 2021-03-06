# Go Paili! (몬스터 키우기)
JAVA 콘솔 게임

### [작품 소개]
유저가 포켓몬(파이리)을 선택하여 2개의 마을을 돌아다니며 야생포켓몬을 잡고,체육관배틀도 하며 포켓몬을 성장(레벨 업)시키는 게임입니다. <br/>
엔딩을 하려면 각 마을의 체육관 관장을 이겨서 2개의 뱃지를 모두 얻어야 게임이 종료됩니다.


### [주요 기능]
#### 1.포켓몬 배틀 기능
- 유저의 포켓몬이 먼저 선공을 하고 후에 상대방 포켓몬이 공격을 합니다.<br/>
- 배틀 중에 상처약을 사용해 포켓몬을 치료 할 수 있습니다.<br/>
- 배틀 중에 도망가기를 선택할 수 있습니다.

#### 2.야생포켓몬 배틀
- 야생 포켓몬 배틀 <br/>
- 야생 포켓몬 잡기: HP가 절반이하로 떨어졌을 때 몬스터볼을 던져서 포켓몬을 잡을 수 있습니다.

#### 3.포켓몬센터
- 포켓몬 치료 : 배틀 중에 떨어진 Hp를 회복시켜줍니다.<br/>
- 아이템사기 : 몬스터볼과 상처약을 살 수 있습니다.

#### 4.유저 상태창 보기
- 보유물품 : 유저의 소지금과 보유 뱃지를 보여주는 공간 입니다.<br/>
- 포켓몬들 : 현재 자신이 소유하고 있는 포켓몬들을 보여주는 공간 입니다. <br/>
- 아이템 가방 : 유저가 가지고 있는 몬스터 볼과 상처약의 갯수를 보여주는 공간 입니다.

#### 5.맵 이동
- 태초마을 > 회색시티 > 블루시티로 진행 되어집니다.<br/>
맵을 이동하려면 각 마을의 체육관 관장을 이겨서 뱃지를 얻어야 다음 마을로 이동되어집니다. 


### [사용한 쓰레드]
#### 1.배경음악 쓰레드 (*영상은 음악 저작권 상의 이유로 음소거 처리하였습니다)
- 각 마을과 체육관, 포켓몬센터, 야생배틀 시 해당하는 환경에서 배경음악이 실행됩니다. 
 
#### 2.밤/낮 쓰레드 
- 밤과 낮은 주기적으로 바뀌어져 실행됩니다. <br/>
- 밤과 낮에 해당하는 포켓몬들의 공격력이 증가하는 효과를 가지게하였습니다.

#### 3.자동전투쓰레드
- 2마리의 포켓몬이 서로 자동으로 전투하게 만들었습니다. 

#### 4.응원쓰레드
- 자동 전투시 응원하는 쓰레드를 만들어 해당 응원방법을 사용하면 자신의 포켓몬의 공격력과 HP가 증가하게 됩니다.


### [작품 영상]
https://youtu.be/A0_msbJ9ecw
