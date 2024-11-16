import axios from 'axios';
import React, { useState } from 'react';

const PaymentComponent = () => {
    const [isLoading, setIsLoading] = useState(false);

    const requestPay = () => {
        const IMP = window.IMP;
        IMP.init('imp82236188'); // 실제 가맹점 식별코드를 입력하세요.

        setIsLoading(true);

        IMP.request_pay({
            pg: "kakaopay",
            pay_method: "card",
            merchant_uid: "ORD20180131-1111011",   // 주문번호 계속 바껴야함 아니면 안되더라....
            name: "노르웨이 회전 의자",
            amount: 64900,                         // 결제 금액
            buyer_email: "gildong@gmail.com",
            buyer_name: "홍길동",
            buyer_tel: "010-4242-4242",
            buyer_addr: "서울특별시 강남구 신사동",
            buyer_postcode: "01181"
        }, (rsp) => { // 결제 완료 후 콜백 함수
            if (rsp.imp_uid != null) {
                axios.get(`http://localhost:8080/verify/${rsp.imp_uid}`)
                    .then((res) => {
                        console.log('');
                    }).catch((err) => {
                        console.log(err);
                    });
                alert('결제 성공');
            } else {
                alert('결제 실패');
            }
            console.log(rsp);
            setIsLoading(false); // 결제 요청 종료 상태 설정
        });
    };

    return (
        <div>
            <h2>결제하기</h2>
            <button onClick={requestPay} disabled={isLoading}>
                {isLoading ? "결제 중..." : "결제하기"}
            </button>
        </div>
    );
};

export default PaymentComponent;
