# Payment (IamPort/PortOne API)
- 결제 시스템 구축을 위한 샘플코드 레포지토리

## 학습목표
- PortOne API를 사용하여 결제 시스템 구축에 대해 학습

## 사용법
- https://portone.io/korea/ko (PortOne 홈페이지에서 회원가입은 필수)

[PortOne 결제 방법 - 채널 관리 추가]
![캡처](/그림2.png)  
![캡처](/그림3.png)  

[연동정보 - 식별코드/APIKey 이미지]
![캡처](/그림1.png)  
```
IMP.init("impXXXXXXXXX");
```
Front 코드내에서 사용하는 코드하는 코드이며 해당 코드라인에사용되는 init메소드 내에 파라미터로는 연동정보 - 식별코드/APIKey 이미지에서 '고객사 식별코드'를 뜻한다.

```
public class IamportConfig {
    @Value("${import.api.key}")
    private String apiKey;

    @Value("${import.api.secret}")
    private String apiSecret;

    // Iamport 빈을 등록
    @Bean
    public IamportClient iamport() {
        return new IamportClient(apiKey, apiSecret);
    }
}
```
Back 코드내에서 사용하는 코드하는 코드이며 해당 코드라인에사용되는 apiKey, apiSecret변수의 값은 연동정보 - 식별코드/APIKey 이미지에서 'REST API Key', 'REST API Secret'을 뜻한다.

## 브렌치 설명
- back
    * 결제 시스템에서 결제후 결제 내용을 저장하기 위한 서버 코드
- front
    * 결제 시스템에서 결제 요청을 하기 위한 프론트 코드