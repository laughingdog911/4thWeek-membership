### My third weekly project(week4)!

It took me two weeks to complete this one...! But I'm getting there. I can manage to navigate and find my errors slowly.
It says 4th week but this is my third project in all... well I'll come up with a better naming system so that it's clearer. 
And naming isn't really important here!

I was to make this UI:

![image](https://github.com/laughingdog911/4thWeek-membership/assets/167860528/d5f7980a-5c2f-4956-a91c-aaaef29c1d42)


### 소스코드 요구 조건

- E-Mail, 비밀번호, 비밀번호 확인, 이름, 휴대폰 번호, 생년월일, 회원 유형을 요청하시오.
- 회원 유형은 Radio Button으로 사용자가 선택할 수 있게 하고, 기본 값은 ‘학생’으로 하시오.
- Check Box를 이용해 최종 사용권 계약서와 개인정보 수집 및 처리 방침 동의를 요청하시오.

### 생년월일

- 생년월일 입력란에서 ‘선택’ 버튼을 탭하면 DatePicker Dialog를 표시하시오.
- DatePicker Dialog에서 Cancel 버튼을 탭하면 DatePicker Dialog를 닫으시오.
- DatePicker Dialog에서 OK 버튼을 탭하면:
‘생년월일을 선택하세요’ TextView를 선택한 생년월일로 변경하시오.
(DatePickerDialog의 결과를 String으로)

### 회원가입’ 버튼을 탭하면 상황에 알맞은 Dialog를 표시하시오.

E-Mail, 비밀번호, 비밀번호 확인, 이름, 연락처, 생년월일 중 하나 이상의 값이 공백인 경우:

- ‘모든 필드를 채워주세요’ 라는 내용의 Dialog 표시

E-Mail에 ‘@’ 기호가 없는 경우:

- ‘잘못된 형식의 E-Mail 입니다.’ 라는 내용의 Dialog 표시

비밀번호의 길이가 8자리 미만인 경우:

- ‘보안을 위해 8자리 이상의 비밀번호를 설정해주세요.’ 라는 내용의 Dialog 표시

비밀번호와 비밀번호 확인이 일치하지 않는 경우:

- ‘비밀번호와 비밀번호 확인이 일치하지 않습니다.’ 라는 내용의 Dialog 표시

최종 사용권 계약서, 개인정보 수집 및 처리 방침 중 하나 이상에 동의하지 않는 경우:

- ‘최종 사용권 계약과 개인정보 수집 및 처리 방침을 읽고 동의해주세요.’라는 내용의 Dialog 표시

그 외 상황인 경우:

- ‘다음 정보로 가입을 진행하시겠습니까?’ 라는 메시지와 함께 사용자가 입력한 인적사항을

Dialog 에 표시 (단, 비밀번호는 제외함.)

- ‘아니오’ 버튼을 탭 하면 Dialog를 닫음.
- ‘예’ 버튼을 탭한 경우 ‘회원 가입’ 버튼을 화면에서 제거하고, CircularProgressIndicator를 표시
- (단, CircularProgressIndicator의 android:indeterminate 값을 true로 설정하여 ProgressBar가 무한하게 회전하도록 설정할 것.)

- 회원 유형 선택은 Enum class를 사용할 것.
- EditText의 목적에 알맞은 Keyboard Type을 제공할 것.
(예를 들어, E-Mail인 경우 E-Mail에 알맞은 키보드 표시,Password인 경우 입력한 값을 표시하지 않음, 전화번호인 경우 숫자 키패드 표시)
