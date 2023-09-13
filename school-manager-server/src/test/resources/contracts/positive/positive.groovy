package contracts.positive

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Get Classroom - Positive Scenario"

    request {
        method 'GET'
        url producer("/classroom/1?index=A")
    }

    response {
        status 200
        body(file('positiveClassroom.json'))
    }
}

Contract.make {
    description "Create Classroom - Positive Scenario"

    request {
        method 'POST'
        url "/classroom/create"
        body(file('positiveClassroom.json'))
        headers {
            contentType(applicationJson())
        }
    }

    response {
        status 200
        body("Classroom was created")
    }
}