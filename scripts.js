const axios = require('axios');

// URLs for API endpoints
const customerUrl = 'http://localhost:8081/api/customers';
const technicianUrl = 'http://localhost:8081/api/technicians';
const repairRequestUrl = 'http://localhost:8081/api/repair-requests';

// Helper function to create entities via POST request
const createEntity = async (url, data) => {
  try {
    const response = await axios.post(url, data);
    return response.data;
  } catch (error) {
    console.error(`Error creating entity: ${error.message}`);
    throw error;
  }
};

// Step 1: Create Customers
const customers = [
  {
    fullName: 'Alice Johnson',
    email: 'alice@example.com',
    phoneNumber: '+1111111111',
    address: '123 Apple St',
    createdAt: new Date().toISOString(), // Ensure createdAt is set
    repairRequests: []
  },
  {
    fullName: 'Bob Smith',
    email: 'bob@example.com',
    phoneNumber: '+2222222222',
    address: '456 Orange Ave',
    createdAt: new Date().toISOString(),
    repairRequests: []
  },
  {
    fullName: 'Charlie Brown',
    email: 'charlie@example.com',
    phoneNumber: '+3333333333',
    address: '789 Banana Blvd',
    createdAt: new Date().toISOString(),
    repairRequests: []
  }
];

// Step 2: Create Technicians
const technicians = [
  {
    fullName: 'John Doe',
    expertise: 'Laptop Repair',
    email: 'john.doe@example.com',
    phoneNumber: '+1234567890',
    repairRequests: []
  },
  {
    fullName: 'Jane Smith',
    expertise: 'Hardware Specialist',
    email: 'jane.smith@example.com',
    phoneNumber: '+9876543210',
    repairRequests: []
  }
];

// Step 3: Create Repair Requests
const createRepairRequests = async (customers, technicians) => {
  const repairRequests = [
    {
      deviceType: 'Laptop',
      deviceModel: 'Dell Inspiron',
      issueDescription: 'Overheating',
      status: 'In Progress',
      createdAt: new Date().toISOString(),
      customerId: customers[1].id, // Assign to Bob Smith
      technicianId: technicians[1].id // Assign to Jane Smith
    },
    {
      deviceType: 'Laptop',
      deviceModel: 'HP Pavilion',
      issueDescription: 'Screen flickering',
      status: 'Pending',
      createdAt: new Date().toISOString(),
      customerId: customers[2].id, // Assign to Charlie Brown
      technicianId: technicians[0].id // Assign to John Doe
    }
  ];

  const createdRepairRequests = await Promise.all(
    repairRequests.map(req => createEntity(repairRequestUrl, req))
  );
  console.log('Created Repair Requests:', createdRepairRequests);
};

// Main function to create customers, technicians, and repair requests
const createEntities = async () => {
  try {
    const createdCustomers = await Promise.all(customers.map(cust => createEntity(customerUrl, cust)));
    console.log('Created Customers:', createdCustomers);

    const createdTechnicians = await Promise.all(technicians.map(tech => createEntity(technicianUrl, tech)));
    console.log('Created Technicians:', createdTechnicians);

    await createRepairRequests(createdCustomers, createdTechnicians);
  } catch (error) {
    console.error('Error creating entities:', error);
  }
};

// Run the function to create entities
createEntities();
