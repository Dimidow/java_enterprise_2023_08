package contracts.negative

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Get Classroom - Negative Scenario (Classroom not found)"

    request {
        method 'GET'
        url "/classroom/999?index=XYZ"
    }

    response {
        status 404
        body("Classroom not found")
    }
}

Contract.make {
    description "Create Classroom - Negative Scenario (Classroom already exists)"

    request {
        method 'POST'
        url "/classroom/create"
        body(file('negativeClassroom.json'))
        headers {
            contentType(applicationJson())
        }
    }

    response {
        status 409
        body("Classroom already exist")
    }
}